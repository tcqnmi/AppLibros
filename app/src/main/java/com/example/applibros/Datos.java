package com.example.applibros;

public class Datos {

    private String lista[][] = {{"Mary Shelley", "Frankenstein"},{"Bram Stoker","Dracula"},
            {"Robert Stevenson","Dr Jekyll & Mr Hyde"},{"Ernest CLine","Ready Player One"},
            {"Alexandra Bracken","Lore"}};

    public Datos(){

    }

    public String[] getTitulos(){

        String [] titulos = new String[lista.length];
        for (int i = 0; i < lista.length; i++) {
            titulos[i]=lista[i][1];
        }

        return titulos;

    }

    public String[] getAutores(){
        String [] autores = new String[lista.length];
        for (int i = 0; i < lista.length; i++) {
            autores[i]=lista[i][0];
        }

        return autores;
    }

    public String getAutor( int pos){

        return lista[pos][0];
    }

    public String getLibro( int pos){

        return lista[pos][1];
    }

    public String libro(){
        for (int i = 0; i < this.lista.length; i++) {
            for (int j = 0; j < this.lista[i].length; j++) {
                String book = String.format("%s -> %s",this.lista[i][i], this.lista[i][j]);
                return book;
            }
        }
        return "error";
    }



}
