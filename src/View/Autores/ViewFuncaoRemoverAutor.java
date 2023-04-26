package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;
public class ViewFuncaoRemoverAutor {
    public void removerAutorPorNome(ControllerAutores gestor) {

        String nome = leStr("Insira o nome do(a) autor(a)");
        ArrayList<Autor> autorParaRemover = gestor.pesquisarAutorPorNome(nome);

        if (autorParaRemover.isEmpty()) {
            System.out.println("Não existem autores com esse nome!");
            System.out.println(" ");
        } else {
            boolean autorEncontrado = false;
            for (Autor autor : autorParaRemover) {
                if (autor.getNome().equals(nome)) {
                    System.out.println(autor);
                    autorEncontrado = true;
                    break;
                }
            }
            if (!autorEncontrado) {
                System.out.println("Autor(a) não encontrado(a)");
                System.out.println(" ");
                return;
            }
        }

        String nomeAutor = leStr("Insira o nome do(a) autor(a) que quer remover");

        boolean removido = gestor.removerAutor(nomeAutor);

        if (removido) {
            System.out.println("Autor(a) eliminado com sucesso");
            System.out.println(" ");
        } else {
            System.out.println("Autor(a) não encontrado(a)");
            System.out.println(" ");
        }
    }

}
