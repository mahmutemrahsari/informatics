        .globl hms_to_sec
# Omformer et klokkeslett (angitt i timer, minutter og sekunder) til
# antall sekunder.

hms_to_sec:

        # Legg inn kode for funksjonen her:
        movq    %RDI,%RAX #antall timer
        movq    %RSI,%RAX #antall minutter
        movq    %RDX,%RAX #antal sekunder
        imulq   $3600,%RDI #Ganger med 3600 for å få antall sekunder
        imulq   $60,%RSI #Ganger med 60 for å få antall sekunder
        movq    %RDI,%RAX
        addq    %RSI,%RAX #Adder alt i RAX og returnerer        
        addq    %RDX,%RAX
        ret


        .globl  sec_to_h
# Gitt et tidspunkt (angitt som sekunder siden midnatt), finn timen.

sec_to_h:

        # Legg inn kode for funksjonen her:

        movq    %RDI,%RAX
        movq    $3600,%R8 #Deler med 3600 for å få antall timer ut fra sekunder 
        cqo
        idivq   %R8
        ret


        .globl  sec_to_s
# Gitt et tidspunkt (angitt som sekunder siden midnatt), finn sekundet.

sec_to_s:

        # Legg inn kode for funksjonen her:

        movq    %RDI,%RAX
        movq    $60,%R9         #Tar modulus 60 og legger inn antall sekunder vi har igjen
        cqo
        idivq   %R9
        movq    %RDX,%RAX
        ret


        .globl  sec_to_m
# Gitt et tidspunkt (angitt som sekunder siden midnatt), finn minuttet.

sec_to_m:

        # Legg inn kode for funksjonen her:

        movq    %RDI,%RAX       #Deler antall sekunder med 60 for å få antall minutter og hvis det er mer enn 60 minutter 
        movq    $60,%R10        #skriver om i timer
        cqo
        idivq   %R10
        movq    %R10,%R11
        movq    $60,%R11
        cqo
        idivq   %R11
        movq    %RDX,%RAX
        ret
                                       