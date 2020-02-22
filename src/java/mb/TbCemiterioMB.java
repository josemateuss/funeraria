/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;
import dao.TbCemiterioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TbCemiterio;

@ManagedBean
@ViewScoped

public class TbCemiterioMB {
    
    private String cemi;
    
    private List<TbCemiterio> lista;
    
    private TbCemiterio cemiterio;
    
    
    public TbCemiterioMB(){
        TbCemiterioDAO dao= new TbCemiterioDAO();
        cemi="";
        lista=dao.consultarTodos();
        cemiterio=new TbCemiterio();
        
    
}
    public void novo(){
        cemiterio=new TbCemiterio();
    }
    
    public void recarregarTodos(){
        TbCemiterioDAO dao=new TbCemiterioDAO();
        lista=dao.consultarTodos();
    }
    
    public void consultar() {
        TbCemiterioDAO dao=new TbCemiterioDAO();
        lista=dao.consultarPorNme(cemi);
        novo();
    }
    public void salvar() {
        TbCemiterioDAO dao=new TbCemiterioDAO();
        dao.incluir(cemiterio);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da inclusão", "Inclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void alterar() {
        TbCemiterioDAO dao=new TbCemiterioDAO();
        dao.juntar(cemiterio);
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da alteração",
                "Alteração efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void excluir() {
        TbCemiterioDAO dao=new TbCemiterioDAO();
        dao.excluir(cemiterio);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão",
                "Exclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    

    /**
     * @return the cemi
     */
    public String getCemi() {
        return cemi;
    }

    /**
     * @param cemi the cemi to set
     */
    public void setCemi(String cemi) {
        this.cemi = cemi;
    }

    /**
     * @return the lista
     */
    public List<TbCemiterio> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TbCemiterio> lista) {
        this.lista = lista;
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
    
}
