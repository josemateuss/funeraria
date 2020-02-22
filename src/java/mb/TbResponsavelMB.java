/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;
import dao.TbResponsavelDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TbResponsavel;

@ManagedBean
@ViewScoped

public class TbResponsavelMB {
    
    private String resp;
    
    private List<TbResponsavel> lista;
    
    private TbResponsavel responsavel;
    
    
    public TbResponsavelMB(){
        TbResponsavelDAO dao= new TbResponsavelDAO();
        resp="";
        lista=dao.consultarTodos();
        responsavel=new TbResponsavel();
        
    
}
    public void novo(){
        responsavel=new TbResponsavel();
    }
    
    public void recarregarTodos(){
        TbResponsavelDAO dao=new TbResponsavelDAO();
        lista=dao.consultarTodos();
    }
    
    public void consultar() {
        TbResponsavelDAO dao=new TbResponsavelDAO();
        lista=dao.consultarPorNme(resp);
        novo();
    }
    public void salvar() {
        TbResponsavelDAO dao=new TbResponsavelDAO();
        dao.incluir(responsavel);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da inclusão", "Inclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void alterar() {
        TbResponsavelDAO dao=new TbResponsavelDAO();
        dao.juntar(responsavel);
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da alteração",
                "Alteração efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void excluir() {
        TbResponsavelDAO dao=new TbResponsavelDAO();
        dao.excluir(responsavel);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão",
                "Exclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    

    /**
     * @return the resp
     */
    public String getResp() {
        return resp;
    }

    /**
     * @param resp the resp to set
     */
    public void setResp(String resp) {
        this.resp = resp;
    }

    /**
     * @return the lista
     */
    public List<TbResponsavel> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TbResponsavel> lista) {
        this.lista = lista;
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
