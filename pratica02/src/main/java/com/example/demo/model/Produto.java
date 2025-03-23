package com.example.demo.model;

public class Produto {
    private Long id;
    private String name;

    public Produto(){}

    // construtor com campos
    public Produto(Long id, String name){
        this.id = id;
        this.name = name;
    }

    /*  Gerar Getters and setters automaticamente:
        botao direito;
        source action;
        Generate getters and setters;
        selecione quais atribuitos vc precisa.
    */

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
