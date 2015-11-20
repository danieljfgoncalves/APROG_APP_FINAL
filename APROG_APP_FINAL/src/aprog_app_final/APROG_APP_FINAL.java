/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aprog_app_final;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Francisco
 */
public class APROG_APP_FINAL {

    public static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        String deputados[][] = new String[230][4];
        int nDep = 0;
        nDep = lerDeputados(deputados, nDep);
        alterarInfoDep(deputados, nDep);
    }
    
    
    private static void menu() {
        
    }

    private static int lerDeputados(String[][] deputados, int nDep) throws FileNotFoundException {
        Scanner fInput = new Scanner(new File("Deputados.txt"), "UTF-8");
        do {
            String str = fInput.nextLine();
            if (str.length() > 0) {
                String[] tmp = str.split(";");
                for (int i = 0; i < deputados[nDep].length; i++) {
                    deputados[nDep][i] = tmp[i].trim();
                }

                nDep++;
            }
        } while (fInput.hasNextLine() && nDep < deputados.length);
        fInput.close();

        
        listar(deputados, nDep);
        System.out.println("----------------------------------");
        return nDep;

    }

    private static void alterarInfoDep(String[][] deputados, int nDep) {
        String cod;
        int op;
        System.out.println("Introduza o código do deputado a modificar");
        cod = ler.next();
        
        
        for (int i = 0; i < nDep; i++) {
            if (deputados[i][0].equalsIgnoreCase(cod)) {
                do {
                    op = textoAlteracaoInfo();
                    switch (op) {
                        case 1:
                            alterarCodigoDep(deputados, i);
                            break;
                        case 2:
                            alterarNomeDep(deputados, i);
                            break;
                        case 3:
                            alterarPartidoDep(deputados, i);
                            break;
                        case 4:
                            alterarDataNascDep(deputados, i);
                            break;
                        case 5:
                            listar(deputados, nDep);
                            break;
                        case 0:
                            System.out.println("\nFIM");
                            break;
                        default:
                            System.out.println("\nCódigo inválido!\nIntroduza uma das opções disponíveis.\n");
                            break;

                    }
                } while (op != 0);
            }
        }
    }

    public static int textoAlteracaoInfo() {
        String texto = "1 - Mudar o código de identificação\n"
                + "2 - Mudar o nome do deputado\n"
                + "3 - Mudar o partido do deputado\n"
                + "4 - Mudar a data de nascimento do deputado\n"
                + "5 - Listar\n"
                + "0 - Sair";
        System.out.println(texto);
        int opcao = ler.nextInt();
        return opcao;
    }

    public static void alterarCodigoDep(String[][] deputados, int linha) {
        String novoCod;
        System.out.println("Introduza um novo código (max. 5char)");
        novoCod = ler.next();
        deputados[linha][0] = novoCod;
    }
    
    public static void alterarNomeDep(String[][] deputados, int linha) {
        String novoNome, apelido;
        System.out.println("Introduza um novo nome (max. 30char)");
        ler.useDelimiter("\n");                                                     //PROBLEMA RESOLVIDO ler.nextLine()
        novoNome = ler.next();
        deputados[linha][1] = novoNome;
    }
    
    public static void alterarPartidoDep(String[][] deputados, int linha) {
        String novoPartido;
        System.out.println("Introduza um novo partido (max. 10char)");
        novoPartido = ler.next();
        deputados[linha][2] = novoPartido;
    }
    
    public static void alterarDataNascDep(String[][] deputados, int linha) {
        String novaData;
        System.out.println("Introduza uma nova data de nascimento (max. 12char)");
        novaData = ler.next();
        deputados[linha][3] = novaData;
    }

    public static void listar(String[][] deputados, int nDep) {
        for (int i = 0; i < nDep; i++) {
            for (int j = 0; j < deputados[i].length; j++) {
                System.out.print(deputados[i][j] + "\t");
            }
            System.out.println("");
        }

    }
    
}
