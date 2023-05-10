package View;


import Controller.*;
import Controller.ControllerAutores;
import Controller.ControllerLivros;
import Controller.ControllerLogin;
import Utilidades.MensagemBoasVindas;
import View.Autores.MenuViewAutores;
import View.Livros.MenuViewLivros;
import View.Login.ViewLogin;
import View.Reservas.MenuViewReservas;
import View.Socios.MenuViewSocios;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class ViewAplicacao {
    public ViewAplicacao() {
        controllerLogin = new ControllerLogin(new ViewLogin());
    }
    private ControllerLogin controllerLogin;
    ControllerLivros lerEgravarLivros = new ControllerLivros();
    ControllerAutores lerEgravarAutores = new ControllerAutores();
    ControllerSocios lerEgravarSocios = new ControllerSocios();
    ControllerReservas lerEGravarReservas = new ControllerReservas(lerEgravarSocios,lerEgravarLivros);
    public void Iniciar() {
        //Ler os ficheiros
        lerEgravarAutores.lerAutorDeFicheiro();
        lerEgravarLivros.lerLivrosDeFicheiro();
        lerEgravarSocios.lerSociosDoFicheiro();
        lerEGravarReservas.lerLivrosDeFicheiroReserva();
        MensagemBoasVindas.textoInicial();
        MensagemBoasVindas.mensagemBoasVindas();


        // Iniciar o sistema
        //mensagemUtilizadorParaRegisto();
        menuPrincipal();

        // Criar instância do ControllerLogin
        controllerLogin = new ControllerLogin(new ViewLogin());

    }

    public void mensagemUtilizadorParaRegisto() {
        int opcao;

        do {
            System.out.println("Se já estás registado no sistema, selecione a opção 1 para efetuar o login");
            System.out.println("1 - Login");
            System.out.println("Se não, efetue o registo!");
            System.out.println("2 - Efetuar registo");
            System.out.println("3 - Sair");

            try {
                opcao = ler.nextInt();
                switch (opcao) {
                    case 1:
                        controllerLogin = new ControllerLogin(new ViewLogin());
                        boolean loginSucesso = controllerLogin.iniciar();
                        if (loginSucesso) {
                            ViewLogin.mostrarMensagemDeLoginComSucesso();
                            menuPrincipal();
                        } else {
                            ViewLogin.mostrarMensagemDeLoginFalhado();
                        }
                        break;
                    case 2:
                        controllerLogin.registar();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Por favor, insira uma opção válida numérica.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 3);
    }

    public void menuPrincipal() {

        int opcao;

        do {
            try {
                System.out.println("## Menu principal ##");
                System.out.println("Selecione uma opcao:");
                System.out.println("1 - Livros");
                System.out.println("2 - Autores");
                System.out.println("3 - Reservas");
                System.out.println("4 - Sócios");
                System.out.println("5 - Fechar e gravar");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1:
                        MenuViewLivros mostrarMenu = new MenuViewLivros();
                        mostrarMenu.menuLivros();
                        break;
                    case 2:
                        MenuViewAutores mostraMenu = new MenuViewAutores();
                        mostraMenu.menuAutores();
                        break;
                    case 3:
                        MenuViewReservas mostrarMenuReservas = new MenuViewReservas();
                        mostrarMenuReservas.menuReservas();
                        break;
                    case 4:
                        MenuViewSocios menuSocios = new MenuViewSocios();
                        menuSocios.menuSocios();
                        break;
                    case 5:
                        lerEgravarLivros.gravarLivrosParaFicheiro();
                        lerEgravarAutores.gravarAutorParaFicheiro();
                        lerEgravarSocios.gravarSociosParaFicheiro();
                        lerEGravarReservas.gravarReservasParaFicheiro();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Por favor, insira uma opção válida numérica.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }

        } while (opcao != 6);
    }



}
