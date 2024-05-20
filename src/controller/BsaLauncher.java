package controller;

import models.Score;
import models.Vak;

import java.util.Scanner;

public class BsaLauncher {

    public static void main(String[] args) {
        final double CIJFER_ONDERGRENS = 1.0;
        final double CIJFER_BOVENGRENS = 10.0;
        final double CESUUR = 5.5;
        final int TOTAAL_TE_BEHALEN_STUDIEPUNTEN = 28;
        int sumBehaaldeStudiepunten = 0;

        Vak[] vakken = new Vak[7];
        vakken[0] = new Vak("Project Fasten Your Seatbelts", 12, CESUUR);
        vakken[1] = new Vak("Programming", 3, CESUUR);
        vakken[2] = new Vak("Databases", 3, CESUUR);
        vakken[3] = new Vak("Personal Skills", 2, CESUUR);
        vakken[4] = new Vak("Project Skills", 2, CESUUR);
        vakken[5] = new Vak("OOP", 3, CESUUR);
        vakken[6] = new Vak("User Interaction", 3, CESUUR);

        Score[] scores = new Score[7];

        // scanner declareren om input op te halen
        Scanner input = new Scanner(System.in);
        System.out.println("Voer de behaalde cijfers in:");
        // for loop om input op te halen en op te slaan
        for (int i = 0; i < scores.length; i++) {
            double behaaldeCijfer;
            do {
                System.out.printf("%s: ", vakken[i].getName());
                behaaldeCijfer = input.nextDouble();
                input.nextLine(); // enter opvangen die blijft hangen, zodat je double cijfers kunt invoeren zonder foutmelding
            } while (behaaldeCijfer < CIJFER_ONDERGRENS || behaaldeCijfer > CIJFER_BOVENGRENS);
            scores[i] = new Score(vakken[i], behaaldeCijfer); // if statement is niet nodig, de loop eindigt pas als het cijfer tussen de 1,0 en 10,0 ligt

            // som van alle studiepunten samen
            sumBehaaldeStudiepunten += scores[i].getBehaaldePunten();// let op dat je de juiste array aanspreekt om de som op te halen, anders krijg je de som van alle te behalen punten, dat is altijd 28
        }
        // toon resultaten
        for (int i = 0; i < vakken.length; i++) {
            System.out.printf("Vak/project: %-30s Cijfer: %-6.2f Behaalde punten: %-5d\n", vakken[i].getName(), scores[i].getCijfer(), scores[i].getBehaaldePunten());
        }
        System.out.printf("Totaal behaalde studiepunten zijn: %d/%d", sumBehaaldeStudiepunten, TOTAAL_TE_BEHALEN_STUDIEPUNTEN);
    }
}
