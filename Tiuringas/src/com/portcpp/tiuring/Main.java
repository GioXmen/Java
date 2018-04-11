package com.portcpp.tiuring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.*;
import java.util.Scanner;



public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        int galvute,busena,so=0, bus=0, eil=0, pereilutes=0,trig=0;

        int [] s;
        s = new int [1000];

        String juosta2,temp;
        char temp2;



        System.out.println("**************************************************************************");
        System.out.println("*        Ernesto Lobacevskio tiuringo masina Java pavidale               *");
        System.out.println("**************************************************************************");
        System.out.println("Iveskite teksto faila: 1.txt / 2.txt / 3.txt / 4.txt ");


        Scanner scan = new Scanner(System.in);
        String failas = scan.next();

        Scanner inFile = new Scanner(new FileReader(failas)); // pasirinkti kuri teksto faila
        galvute = inFile.nextInt();
        juosta2 = inFile.next();


        StringBuilder juosta= new StringBuilder(juosta2);



        String [] [] rasti, pakeisti, kryptis, nbusena;
        rasti = new String [25][100];
        pakeisti = new String [25][100];
        kryptis = new String [25][100];
        nbusena = new String [25][100];

        while (inFile.hasNextInt()) {
            busena = inFile.nextInt();
            rasti[busena][s[busena]]=inFile.next();
            pakeisti[busena][s[busena]]=inFile.next();
            kryptis[busena][s[busena]]=inFile.next();
            nbusena[busena][s[busena]]=inFile.next();
            //System.out.println(busena+ " "+ rasti[busena][s[busena]] + " " + pakeisti[busena][s[busena]] + " " + kryptis[busena][s[busena]] + " " + nbusena[busena][s[busena]]);

            s[busena]=s[busena]+1;
            eil=eil+1;
        }


        //System.out.println(0+ " "+ rasti[0][3] + " " + pakeisti[0][3] + " " + kryptis[0][3] + " " + nbusena[0][3]);

        while((galvute>-1)&&(galvute<juosta.length())) {

            //System.out.println(galvute);

            if(juosta.substring(galvute-1,galvute).equals("*")){



                for(int i=0; i<s[bus];i++){
                if((rasti[bus][i].equals("*"))&&(pakeisti[bus][i].equals("*"))){trig=1; so=i;}

            }
            }

            temp=pakeisti[bus][so];

            if((juosta.substring(galvute-1,galvute).equals(rasti[bus][so]))||(juosta.substring(galvute-1,galvute).equals("*"))||(rasti[bus][so].equals("*"))) {
                if((pakeisti[bus][so].equals("*"))&&(juosta.substring(galvute-1,galvute).equals("*"))){temp="*";}
                if((pakeisti[bus][so].equals("*"))&&(!juosta.substring(galvute-1,galvute).equals("*"))){temp=juosta.substring(galvute-1,galvute);}

                if(trig==1){temp="*";}


                temp2 = temp.charAt(0);


                juosta.setCharAt(galvute-1, temp2);

                if(!kryptis[bus][so].equals("*")){
                    if (kryptis[bus][so].equals("R")){galvute=galvute+1;}
                    if (kryptis[bus][so].equals("L")){galvute=galvute-1;}
                }
                if(nbusena[bus][so].equals("X")){break;}

                System.out.println(juosta);

                bus=Integer.parseInt(nbusena[bus][so]);

                pereilutes=0;
                so=0;
            } else if (!juosta.substring(galvute-1,galvute).equals(rasti[bus][so])){so=so+1;}

            pereilutes=pereilutes+1;

            if(pereilutes>eil*2){break;}

            trig=0;
        }

        //System.out.println(0+ " "+ rasti[0][2] + " " + pakeisti[0][2] + " " + kryptis[0][2] + " " + nbusena[0][2]);

    }


}
