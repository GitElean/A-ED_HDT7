/***
 * Universidad del Valle de Guatemala
 * Estructuras de datos
 * Hoja de trabajo #7
 * Abril 2021
 * @Author: Elean Rivas 19062
 * Controller class
 */
package traductorArbol;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.nio.*;
import java.io.*;
import java.util.stream.Stream;

public class Controller {
    Scanner scan = new Scanner(System.in);

    BinaryTreeAssociotions Dictionary = new BinaryTreeAssociotions();

    /***
     * Ejecuta el programa principal
     */
    public void execute(){
        //Variable para validaciones
        Boolean validate;
        //opciones del menu
        int menu = 0;


        System.out.println("Bienvenido al traductor");

        try {
            Stream<String> lines = Files.lines(Paths.get("diccionario.txt"), StandardCharsets.UTF_8);
            lines.forEach(i->{
                String english = i.substring(i.indexOf("(")+1, i.indexOf(","));
                String spanish = i.substring(i.indexOf(",")+2, i.indexOf(")"));
                String french = i.substring(i.indexOf(",")+3, i.indexOf(")"));
                Associations<String, String, String> association = new Associations<String, String, String>(english, spanish, french);
                BinaryTreeAssociotions SubTree = new BinaryTreeAssociotions(association);
                Dictionary.newTranslation(SubTree);
            });
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        String s;
        //Despliega el menu
        do {
            System.out.println("Ingresa el número de una opcion del menu:" +
                    "\n1.Mostrar la colección ordenada por ingles" +
                    "\n2.Traducir archivo texto.txt" +
                    "\n3.Salir");
            do{
                validate = false;
                String menuStr = scan.nextLine();
                try {
                    menu = Integer.parseInt(menuStr);
                    if((menu>=1)&&(menu<=3)) {
                        validate = true;
                    }else {
                        System.out.println("Ingrese una opción correcta");
                        validate = false;
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Ingrese una opción correcta");
                    validate = false;
                }
            }while(validate==false);

            //Funcion 1 Se realiza el in Order Association
            if(menu==1) {
                Dictionary.inOrderAssociation();
            }

            //Funcion 2
            //Se pide un archivo para traducir y luego lo muestra traducido
            if(menu==2) {
                boolean errorOnFile=false;
                String fileDirectory;

                do {
                    System.out.println("Ingresa la direccion del archivo para traducir el texto: ");
                    fileDirectory = scan.nextLine();
                    try {
                        //Se lee el archivo
                        Scanner scann = new Scanner(new File(fileDirectory));
                        String line = "";
                        String traduction="\t";
                        String textForTraduction="\t";
                        while (scann.hasNextLine()) {
                            line = scann.nextLine()+ " ";
                            //Se hace un arreglo de strings
                            String[] text = line.split(" ");
                            //Se recorre la linea del archivo txt
                            for (int i = 0; i < text.length; i++) {
                                String word = text[i];
                                String colons ="";
                                if(word.contains(".")){
                                    if(word.indexOf(".")==(word.length()-1))
                                        word=word.substring(0, word.indexOf("."));
                                    colons=".";
                                }
                                if(word.contains(",")){
                                    if(word.indexOf(",")==(word.length()-1))
                                        word=word.substring(0, word.indexOf(","));
                                    colons=",";
                                }
                                textForTraduction = " " + textForTraduction + word + colons + " ";
                                traduction =  " "+ traduction + Dictionary.englishToTohers(word)+colons + " ";
                            }

                        }
                        //Muestra el texto inicial y el texto final ya traducido
                        System.out.println("Texto a Traducir");
                        System.out.println(textForTraduction);
                        System.out.println("Texto Traducido");
                        System.out.println(traduction);
                        errorOnFile=false;
                    } catch (Exception e) {
                        //Verifica que la direccion sea valida
                        System.out.println("Error en datos ingresado");
                        System.out.println("Verifica la dirección del archivo ingresado sea correcta");
                        errorOnFile=true;

                    }
                }while(errorOnFile);

            }
            //Sale del menu
        } while (menu!=3);
    }
}
