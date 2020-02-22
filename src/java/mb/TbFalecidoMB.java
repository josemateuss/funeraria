/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TbCemiterioDAO;
import dao.TbFalecidoDAO;
import dao.TbResponsavelDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TbCemiterio;
import model.TbFalecido;
import model.TbResponsavel;

@ManagedBean
@ViewScoped

public class TbFalecidoMB {

    private String fale;

    private List<TbFalecido> lista;

    private List<TbCemiterio> listace;

    private List<TbResponsavel> listare;

    private TbFalecido falecido;

    private TbCemiterio cemiterio;

    private TbResponsavel responsavel;

    public TbFalecidoMB() {
        TbFalecidoDAO dao = new TbFalecidoDAO();
        TbCemiterioDAO daoce = new TbCemiterioDAO();
        TbResponsavelDAO daore = new TbResponsavelDAO();
        fale = "";
        lista = dao.consultarTodos();
        listace = daoce.consultarTodos();
        listare = daore.consultarTodos();
        falecido = new TbFalecido();
        cemiterio = new TbCemiterio();
        responsavel = new TbResponsavel();
    }

//    public void incluirCemiterioFalecido(TbCemiterio cemiterio) {
//        cemiterio.setTbCemiterio(cemiterio);
//        TbFalecidoDAO dao = new TbFalecidoDAO();
//        lista = dao.consultarTodos();
//        
//    public void incluirResponsavelFalecido(TbResponsavel responsavel) {
//        responsavel.setTbResponsavel(responsavel);
//        TbFalecidoDAO dao = new TbFalecidoDAO();
//        lista = dao.consultarTodos();
//    }
    public void incluirCemiterioFalecido (TbCemiterio cemiterio){
        cemiterio.setNmeCemiterio(fale);
        TbFalecidoDAO dao = new TbFalecidoDAO();
        lista = dao.consultarTodos();    
    }
    
    public void novo() {
        falecido = new TbFalecido();
        cemiterio = new TbCemiterio();
        responsavel = new TbResponsavel();
    }

    public void recarregarTodos() {
        TbFalecidoDAO dao = new TbFalecidoDAO();
        TbCemiterioDAO daoce = new TbCemiterioDAO();
        TbResponsavelDAO daore = new TbResponsavelDAO();
        lista = dao.consultarTodos();
        listace = daoce.consultarTodos();
        listare = daore.consultarTodos();

    }

    public void consultar() {
        TbFalecidoDAO dao = new TbFalecidoDAO();

        lista = dao.consultarPorNme(fale);
        novo();
    }

    public void salvar() {
        TbFalecidoDAO dao = new TbFalecidoDAO();
        dao.incluir(falecido);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da inclusão", "Inclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void alterar() {
        TbFalecidoDAO dao = new TbFalecidoDAO();
        dao.juntar(falecido);
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da alteração",
                "Alteração efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void excluir() {
        TbFalecidoDAO dao = new TbFalecidoDAO();
        TbCemiterioDAO daoce = new TbCemiterioDAO();
        TbResponsavelDAO daore = new TbResponsavelDAO();
        daoce.excluir(cemiterio);
        daore.excluir(responsavel);
        dao.excluir(falecido);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão",
                "Exclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * @return the func
     */
    public String getFale() {
        return fale;
    }

    /**
     * @param fale the fale to set
     */
    public void setFale(String fale) {
        this.fale = fale;
    }

    /**
     * @return the lista
     */
    public List<TbFalecido> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TbFalecido> lista) {
        this.lista = lista;
    }

    /**
     * @return the funcionario
     */
    public TbFalecido getFalecido() {
        return falecido;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFalecido(TbFalecido funcionario) {
        this.falecido = falecido;
    }

    /**
     * @return the listafk
     */
    public List<TbCemiterio> getListace() {
        return listace;
    }

    /**
     * @param listace the listace to set
     */
    public void setListace(List<TbCemiterio> listace) {
        this.listace = listace;
    }

    /**
     * @return the listare
     */
    public List<TbResponsavel> getListare() {
        return listare;
    }

    /**
     * @param listare the listare to set
     */
    public void setListare(List<TbResponsavel> listare) {
        this.listare = listare;
    }
    /**
     * @return the cemiterio
     */
    public TbCemiterio getCemiterio() {
        return cemiterio;
    }

    /**
     * @param cemiterio the cemiterio to set
     */
    public void setCemiterio(TbCemiterio cemiterio) {
        this.cemiterio = cemiterio;
    }
    
    /**
     * @return the responsavel
     */
    public TbResponsavel getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(TbResponsavel responsavel) {
        this.responsavel = responsavel;
    }

}