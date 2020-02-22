package mb;
import dao.TbFornecedorDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TbFornecedor;

@ManagedBean
@ViewScoped

public class TbFornecedorMB {
    
    private String forn;
    
    private List<TbFornecedor> lista;
    
    private TbFornecedor fornecedor;
    
    
    public TbFornecedorMB(){
        TbFornecedorDAO dao= new TbFornecedorDAO();
        forn="";
        lista=dao.consultarTodos();
        fornecedor=new TbFornecedor();
        
    
}
    public void novo(){
        fornecedor=new TbFornecedor();
    }
    
    public void recarregarTodos(){
        TbFornecedorDAO dao=new TbFornecedorDAO();
        lista=dao.consultarTodos();
    }
    
    public void consultar() {
        TbFornecedorDAO dao=new TbFornecedorDAO();
        lista=dao.consultarPorNme(forn);
        novo();
    }
    public void salvar() {
        TbFornecedorDAO dao=new TbFornecedorDAO();
        dao.incluir(fornecedor);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da inclusão", "Inclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void alterar() {
        TbFornecedorDAO dao=new TbFornecedorDAO();
        dao.juntar(fornecedor);
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da alteração",
                "Alteração efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void excluir() {
        TbFornecedorDAO dao=new TbFornecedorDAO();
        dao.excluir(fornecedor);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão",
                "Exclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    

    /**
     * @return the forn
     */
    public String getForn() {
        return forn;
    }

    /**
     * @param forn the forn to set
     */
    public void setForn(String forn) {
        this.forn = forn;
    }

    /**
     * @return the lista
     */
    public List<TbFornecedor> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TbFornecedor> lista) {
        this.lista = lista;
    }

    /**
     * @return the fornecedor
     */
    public TbFornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(TbFornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
