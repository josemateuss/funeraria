/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;
import dao.TbServicoDAO;
import dao.TdFuncaoDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TbServico;
import model.TdFuncao;

@ManagedBean
@ViewScoped

public class TbServicoMB {
    
    private String serv;
    
    private List<TbServico> lista;
    
    private List<TdFuncao> listafk;
    
    private TbServico servico;
    
    private TdFuncao funcao;
    
    
    public TbServicoMB(){
        TbServicoDAO dao= new TbServicoDAO();
        TdFuncaoDAO daofk=new TdFuncaoDAO();
        serv="";
        lista=dao.consultarTodos();
        listafk=daofk.consultarTodos();
        servico=new TbServico();
        funcao=new TdFuncao();    
    }
    
    public void incluirFuncaoServiço(TdFuncao funcao){
        servico.setTdFuncao(funcao);
        TbServicoDAO dao= new TbServicoDAO();
        lista=dao.consultarTodos();
    }
    public void novo(){
        servico=new TbServico();
        funcao=new TdFuncao();
    }
    
    public void recarregarTodos(){
        TbServicoDAO dao=new TbServicoDAO();
        TdFuncaoDAO daofk=new TdFuncaoDAO();
        lista=dao.consultarTodos();
        listafk=daofk.consultarTodos();
        
    }
    
    public void consultar() {
        TbServicoDAO dao=new TbServicoDAO();
        
        lista=dao.consultarPorNme(serv);
        novo();
    }
    public void salvar() {
        TbServicoDAO dao=new TbServicoDAO();
        dao.incluir(servico);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da inclusão", "Inclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void alterar() {
        TbServicoDAO dao=new TbServicoDAO();
        dao.juntar(servico);
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da alteração",
                "Alteração efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void excluir() {
        TbServicoDAO dao=new TbServicoDAO();
        TdFuncaoDAO daofk=new TdFuncaoDAO();
        daofk.excluir(funcao);
        dao.excluir(servico);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão",
                "Exclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    /**
     * @return the serv
     */
    public String getServ() {
        return serv;
    }

    /**
     * @param serv the serv to set
     */
    public void setServ(String serv) {
        this.serv = serv;
    }

    /**
     * @return the lista
     */
    public List<TbServico> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TbServico> lista) {
        this.lista = lista;
    }

    /**
     * @return the servico
     */
    public TbServico getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(TbServico servico) {
        this.servico = servico;
    }

    /**
     * @return the listafk
     */
    public List<TdFuncao> getListafk() {
        return listafk;
    }

    /**
     * @param listafk the listafk to set
     */
    public void setListafk(List<TdFuncao> listafk) {
        this.listafk = listafk;
    }

    /**
     * @return the funcao
     */
    public TdFuncao getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(TdFuncao funcao) {
        this.funcao = funcao;
    }
    
}