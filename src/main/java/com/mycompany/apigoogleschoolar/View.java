
package com.mycompany.apigoogleschoolar;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author balaz
 */
public class View {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la universidad para buscar");
        String QUERY = scanner.nextLine();
        System.out.println("Buscando: " + QUERY);
        AuthorController controller  = new AuthorController();
        List<AuthorModel> authors = controller.fetch(QUERY);
        if(authors != null){
            System.out.println("La lista de los mejores 10 investigadores: "+ QUERY);
            authors.forEach(author -> {
                System.out.println(author.getName());
            });
            System.out.println("¿Desea guardar en la base de datos? Y/N");
            boolean ans = ("Y".equals(scanner.nextLine()));
            if(ans){
                controller.saveAuthors(authors);
            }else{
                System.out.println("Operacion no realizada");
            }
        }else{
            System.out.println("Ocurrio un error vuelve a intentarlo");
        }
    }
    
}
