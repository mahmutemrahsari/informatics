import java.sql.*;
import java.util.*;

// sarime
// Oblig 6

public class TimelisteDb {
    private Connection connection;

    public TimelisteDb(Connection connection) {
        this.connection = connection;
    }

    public void printTimelister() throws SQLException {
        Statement stmt = connection.createStatement();
        String query = "select timelistenr as tlnr,"
                + "status as stts,"
                + "beskrivelse as bsk "
                + "from tliste";

        ResultSet rs = stmt.executeQuery(query);

        System.out.printf("%15s %20s %40s", "timelistenr" , "status", "beskrivelse");
        System.out.println();

        while (rs.next()){
            int timelistenr = rs.getInt("tlnr");
            String status = rs.getString("stts");
            String beskrivelse = rs.getString("bsk");
            System.out.printf("%15s %20s %40s",timelistenr, status, beskrivelse);
            System.out.println();

        }

    }

    public void printTimelistelinjer(int timelisteNr) throws SQLException {

        Statement stmt = connection.createStatement();
        String query = "select linjeNr,"
                + "timeantall,"
                + "beskrivelse,"
                + "kumulativt_timeantall "
                + "from tlistelinje where timelisteNr =" + timelisteNr;

        ResultSet rs = stmt.executeQuery(query);

        System.out.printf("%10s %10s %15s %25s", "linjeNr" , "timeantall", "beskrivelse", "kumulativt_timeantall");
        System.out.println();

        while (rs.next()){
            int linjeNr = rs.getInt("linjeNr");
            int timeantall = rs.getInt("timeantall");
            String beskrivelse = rs.getString("beskrivelse");
            int kumulativt_timeantall = rs.getInt("kumulativt_timeantall");
            System.out.printf("%10s %10s %15s %25s",linjeNr, timeantall, beskrivelse, kumulativt_timeantall );
            System.out.println();
        }
    }

    public double medianTimeantall(int timelisteNr) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = "select timeantall "
                        + "from tlistelinje where timelisteNr ="
                        + timelisteNr +" order by timeantall asc";

        ResultSet rs = stmt.executeQuery(query);

        ArrayList<Integer> medianList = new ArrayList<Integer>();  //ArrayList for median

        while (rs.next()){medianList.add(rs.getInt("timeantall"));
        }
        int sizeofList = medianList.size();
        if(sizeofList%2 ==0) //sjekker size of medianList hvis partall eller odd
        {
            return (double)(medianList.get((sizeofList/2)-1) + medianList.get((sizeofList/2)))/(double) 2; //hvis medianlist er partall
        }else {
            return medianList.get((sizeofList/2)-1);
        }
    }

    public void settInnTimelistelinje(int timelisteNr, int antallTimer, String beskrivelse) throws SQLException {
        Statement stmt = connection.createStatement();

        String nonQuery = "insert into tlistelinje (timelisteNr, linjeNr, timeantall, beskrivelse) " +
            " values (" + timelisteNr +  ",(select max(linjeNr) from tlistelinje ) +1 "
            + "," + antallTimer+",'" + beskrivelse + "')";

        stmt.execute(nonQuery);  //Since SQL statement does not return anything
                                // from the servers we need to send it as nonQuery
    }

    public void regnUtKumulativtTimeantall(int timelisteNr) throws SQLException {
        Statement stmt = connection.createStatement();
        Statement stmt2 = connection.createStatement(); //For updateQuery


        String query = "select timeantall, linjeNr from tlistelinje " +
                "where timelisteNr = " + timelisteNr + " order by linjeNr asc";

        ResultSet rs = stmt.executeQuery(query);

        int antall = 0;
        int currentTimeantall= 0;
        String updateQuery = null;

        while(rs.next()){
            currentTimeantall = rs.getInt("timeantall");
            antall = currentTimeantall+antall;      // increments "antall"
            updateQuery = "update tlistelinje set kumulativt_timeantall=" + antall +
            "where linjeNr =" + rs.getInt("linjenr");

           stmt2.execute(updateQuery); // This is update query so we do not get values from server

        }



    }

    /**
     * Hjelpemetode som regner ut medianverdien i en SORTERT liste. Kan slettes om du ikke har bruk for den.
     * @param list Tar inn en sortert liste av integers (f.eks. ArrayList, LinkedList osv)
     * @return medianverdien til denne listen
     */
    private double median(List<Integer> list) {
        int length = list.size();
        if (length % 2 == 0) {
            return (list.get(length / 2) + list.get(length / 2 - 1)) / 2.0;
        } else {
            return list.get((length - 1) / 2);
        }
    }
}
