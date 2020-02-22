package mb;
import dao.TdFuncaoDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TdFuncao;

@ManagedBean
@ViewScoped

public class TdFuncaoMB {
    
    private String fnc;
    
    private List<TdFuncao> lista;
    
    private TdFuncao funcao;
    
    
    public TdFuncaoMB(){
        TdFuncaoDAO dao= new TdFuncaoDAO();
        fnc="";
        lista=dao.consultarTodos();
        funcao=new TdFuncao();
        
    
}
    public void novo(){
        funcao=new TdFuncao();
    }
    
    public void recarregarTodos(){
        TdFuncaoDAO dao=new TdFuncaoDAO();
        lista=dao.consultarTodos();
    }
    
    public void consultar() {
        TdFuncaoDAO dao=new TdFuncaoDAO();
        lista=dao.consultarPorNme(fnc);
        novo();
    }
    public void salvar() {
        TdFuncaoDAO dao=new TdFuncaoDAO();
        dao.incluir(funcao);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da inclusão", "Inclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void alterar() {
        TdFuncaoDAO dao=new TdFuncaoDAO();
        dao.juntar(funcao);
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da alteração",
                "Alteração efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void excluir() {
        TdFuncaoDAO dao=new TdFuncaoDAO();
        dao.excluir(funcao);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão",
                "Exclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    

    /**
     * @return the func
     */
    public String getFnc() {
        return fnc;
    }

    /**
     * @param func the func to set
     */
    public void setFnc(String func) {
        this.fnc = func;
    }

    /**
     * @return the lista
     */
    public List<TdFuncao> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TdFuncao> lista) {
        this.lista = lista;
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
