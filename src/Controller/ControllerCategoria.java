package Controller;


import Model.Categoria;
import Model.Produto;
import Utilidades.GestorFicheiros;

import java.util.ArrayList;
import java.util.Objects;

import static Controller.ControllerProdutos.produtos;

public class ControllerCategoria {
    public static ArrayList<Categoria> categorias = new ArrayList<>();

    public void lerFicheiroCategoria() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("categorias.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");
                if (value_split.length != 0) {
                    Categoria aux = new Categoria(
                            Integer.parseInt(value_split[0]),
                            value_split[1]);

                    categorias.add(aux);
                }

            }
        }
    }

    public void gravarFicheiroCategoria(){
        String conteudo = "";
        for (Categoria aux : categorias) {
            conteudo += aux.getNome() + "\n";
            conteudo += aux.getId() + "\n";

        }
        GestorFicheiros.gravarFicheiro("categorias.txt", conteudo);
    }



    public boolean adicionarCategorias(String nomeCategoria){
        // Verificar se a categoria já existe
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equalsIgnoreCase(nomeCategoria)) {
                return false; // A categoria já existe, não é possível adicioná-la novamente
            }
        }

        Categoria adicionarCategoria = new Categoria(0, nomeCategoria);
        categorias.add(adicionarCategoria);

        return true;
    }

    public Categoria pesquisarCategoriaPorNome(String nomeCategoria){
        for(Categoria categoria : categorias){
            if(Objects.equals(categoria.getNome(), nomeCategoria)){
                return categoria;
            }
        }
        return null;
    }
    public Categoria pesquisarCategoriaPorId(Integer idCategoria){
        for(Categoria categoria : categorias){
            if(Objects.equals(categoria.getId(), idCategoria)){
                return categoria;
            }
        }
        return null;
    }

    public boolean removerCategoria(Categoria categoriaRemover) {
        // Verifica se a categoria está associada a algum livro
        for (Produto livro : produtos) {
            if (livro.getCategoria().getId() == categoriaRemover.getId()) {
                // A categoria está associada a um livro, não é possível remover
                return false;
            }
        }
        // Remove a categoria da lista de categorias
        categorias.remove(categoriaRemover);
        return true;
    }

    public ArrayList<Categoria> listarCategorias() {
        return categorias;
    }
}
