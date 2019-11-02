package com.springboot.app.util.paginator;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender<T> {

    private String url;
    private Page<T> page;
    private int totalPaginas;
    private int numeroElementos;
    private int paginaActual;
    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.totalPaginas = page.getTotalPages();
        this.numeroElementos = page.getSize();
        this.paginaActual = page.getNumber() + 1;
        this.paginas = new ArrayList<PageItem>();

        int desde, hasta;
        if (totalPaginas <= numeroElementos) {
            desde = 1;
            hasta = totalPaginas;
        } else {
            if (paginaActual <= numeroElementos / 2) {
                desde = 1;
                hasta = numeroElementos;
            } else if (paginaActual >= totalPaginas - numeroElementos) {
                desde = totalPaginas - numeroElementos + 1;
                hasta = numeroElementos;
            } else {
                desde = paginaActual - numeroElementos / 2;
                hasta = numeroElementos;
            }
        }

        for (int i = 0; i < hasta; i++) {
            paginas.add(new PageItem(desde + i, paginaActual == desde + i));
        }
    }

    public String getUrl() {
        return url;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public List<PageItem> getPaginas() {
        return paginas;
    }

    public boolean isFirst(){
        return page.isFirst();
    }

    public boolean isLast(){
        return page.isLast();
    }

    public boolean isHasNext(){
        return page.hasNext();
    }
    public boolean isHasPrevious(){
        return page.hasPrevious();
    }
}
