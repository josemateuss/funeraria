/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;
import dao.TdFuncaoDAO;
import dao.TbFuncionarioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TdFuncao;
import model.TbFuncionario;

@ManagedBean
@ViewScoped

public class TbFuncionarioMB {
    
    private String func;
    
    private List<TbFuncionario> lista;
    
    private List<TdFuncao> listafk;
    
    
    private TbFuncionario funcionario;
    
    private TdFuncao funcao;
    
    
    public TbFuncionarioMB(){
        TbFuncionarioDAO dao= new TbFuncionarioDAO();
        TdFuncaoDAO daofk=new TdFuncaoDAO();
        func="";
        lista=dao.consultarTodos();
        listafk=daofk.consultarTodos();
        funcionario=new TbFuncionario();
        funcao=new TdFuncao();
        
    
}
    public void incluirFuncaoFuncionario(TdFuncao funcao){
        funcionario.setTdFuncao(funcao);
        TbFuncionarioDAO dao= new TbFuncionarioDAO();
        lista=dao.consultarTodos();
    }
    
    public void novo(){
        funcionario=new TbFuncionario();
        funcao=new TdFuncao();
    }
    
    public void recarregarTodos(){
        TbFuncionarioDAO dao=new TbFuncionarioDAO();
        TdFuncaoDAO daofk=new TdFuncaoDAO();
        lista=dao.consultarTodos();
        listafk=daofk.consultarTodos();
    }
    
    public void consultar() {
        TbFuncionarioDAO dao=new TbFuncionarioDAO();
        lista=dao.consultarPorNme(func);
        novo();
    }
    public void salvar() {
        TbFuncionarioDAO dao=new TbFuncionarioDAO();
        dao.incluir(funcionario);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da inclusão", "Inclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void alterar() {
        TbFuncionarioDAO dao=new TbFuncionarioDAO();
        dao.juntar(funcionario);
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da alteração",
                "Alteração efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void excluir() {
        TbFuncionarioDAO dao=new TbFuncionarioDAO();
        dao.excluir(funcionario);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão",
                "Exclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    

    /**
     * @return the func
     */
    public String getFunc() {
        return func;
    }

    /**
     * @param func the func to set
     */
    public void setFunc(String func) {
        this.func = func;
    }

    /**
     * @return the lista
     */
    public List<TbFuncionario> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TbFuncionario> lista) {
        this.lista = lista;
    }

    /**
     * @return the funcionario
     */
    public TbFuncionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(TbFuncionario funcionario) {
        this.funcionario = funcionario;
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
