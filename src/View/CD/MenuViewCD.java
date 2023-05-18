package View.CD;

import Controller.ControllerAutores;
import Controller.ControllerCategoria;
import Controller.ControllerProdutos;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewCD {
    ControllerAutores gestorAutor = new ControllerAutores();
    ControllerProdutos gestor = new ControllerProdutos(gestorAutor);
    ControllerCategoria gestorCategoria = new ControllerCategoria();
    ViewListarCd listarCDS= new ViewListarCd();
    ViewAdicionarCd adicionarCDS= new ViewAdicionarCd();

    public void menuCds() {
        int opcao;

        do {
            try {
                System.out.println("## CD's ##");
                System.out.println("------------------------");
                System.out.println("1 - Adicionar cd");
                System.out.println("2 - Listar cd's");
                System.out.println("3 - Editar cd");
                System.out.println("4 - Remover cd");
                System.out.println("5 - Pesquisar cd");
                System.out.println("6 - Gravar");
                System.out.println("7 - Menu anterior");

                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1: adicionarCDS.MenuAdicionarCd(gestor, gestorCategoria);
                    case 2: listarCDS.listarCDS(gestor);
                    case 3: //editar cds
                    case 4: //remover cds
                    case 5: //pesquisar cds
                    case 6: //gravar
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 7);
    }
}
