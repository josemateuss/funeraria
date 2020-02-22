/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;
import dao.TbFornecedorDAO;
import dao.TbProdutoDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.TbFornecedor;
import model.TbProduto;

@ManagedBean
@ViewScoped

public class TbProdutoMB {
    
    private String prod;
    
    private List<TbProduto> lista;
    
    private List<TbFornecedor> listafk;
    
    
    private TbProduto produto;
    
    private TbFornecedor fornecedor;
    
    
    public TbProdutoMB(){
        TbProdutoDAO dao= new TbProdutoDAO();
        TbFornecedorDAO daofk=new TbFornecedorDAO();
        prod="";
        lista=dao.consultarTodos();
        listafk=daofk.consultarTodos();
        produto=new TbProduto();
        fornecedor=new TbFornecedor();
        
    
}
    public void incluirFornecedorProduto(TbFornecedor fornecedor){
        produto.setTbFornecedor(fornecedor);
        TbProdutoDAO dao= new TbProdutoDAO();
        lista=dao.consultarTodos();
    }
    
    public void novo(){
        produto=new TbProduto();
        fornecedor=new TbFornecedor();
    }
    
    public void recarregarTodos(){
        TbProdutoDAO dao=new TbProdutoDAO();
        TbFornecedorDAO daofk=new TbFornecedorDAO();
        lista=dao.consultarTodos();
        listafk=daofk.consultarTodos();
    }
    
    public void consultar() {
        TbProdutoDAO dao=new TbProdutoDAO();
        lista=dao.consultarPorNme(prod);
        novo();
    }
    public void salvar() {
        TbProdutoDAO dao=new TbProdutoDAO();
        dao.incluir(produto);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da inclusão", "Inclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void alterar() {
        TbProdutoDAO dao=new TbProdutoDAO();
        dao.juntar(produto);
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da alteração",
                "Alteração efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void excluir() {
        TbProdutoDAO dao=new TbProdutoDAO();
        dao.excluir(produto);
        novo();
        recarregarTodos();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão",
                "Exclusão efetivada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    

    /**
     * @return the prod
     */
    public String getProd() {
        return prod;
    }

    /**
     * @param prod the prod to set
     */
    public void setProd(String prod) {
        this.prod = prod;
    }

    /**
     * @return the lista
     */
    public List<TbProduto> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TbProduto> lista) {
        this.lista = lista;
    }

    /**
     * @return the produto
     */
    public TbProduto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(TbProduto produto) {
        this.produto = produto;
    }

    /**
     * @return the listafk
     */
    public List<TbFornecedor> getListafk() {
        return listafk;
    }

    /**
     * @param listafk the listafk to set
     */
    public void setListafk(List<TbFornecedor> listafk) {
        this.listafk = listafk;
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