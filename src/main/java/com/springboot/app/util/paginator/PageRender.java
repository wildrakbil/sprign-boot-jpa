package com.springboot.app.util.paginator;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender<T> {

    private String url;
    private Page<T> page;
    private int totaPaginas;
    private int numeroElementos;
    private int paginbaActual;
    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.totaPaginas = page.getTotalPages();
        this.numeroElementos = page.getSize();
        this.paginbaActual = page.getNumber() + 1;
        this.paginas = new ArrayList<PageItem>();

        int desde, hasta;
        if (totaPaginas <= numeroElementos) {
            desde = 1;
            hasta = totaPaginas;
        } else {
            if (paginbaActual <= numeroElementos / 2) {
                desde = 1;
                hasta = numeroElementos;
            } else if (paginbaActual >= totaPaginas - numeroElementos) {
                desde = totaPaginas - numeroElementos + 1;
                hasta = numeroElementos;
            } else {
                desde = paginbaActual - numeroElementos / 2;
                hasta = numeroElementos;
            }
        }

        for (int i = 0; i < hasta; i++) {
            paginas.add(new PageItem(desde + i, paginbaActual == desde + i));
        }
    }

    public String getUrl() {
        return url;
    }

    public int getTotaPaginas() {
        return totaPaginas;
    }

    public int getPaginbaActual() {
        return paginbaActual;
    }

    public List<PageItem> getPaginas() {
        return paginas;
    }

    public boolean isFifst(){
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
