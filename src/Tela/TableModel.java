package Tela;

import estoque.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*;


public class TableModel extends AbstractTableModel{
    private List<Produto> lista;

    private final int COL_ID = 0;
    private final int COL_Nome = 1;
    private final int COL_Descricao = 2;
    private final int COL_Preco = 3;
    private final int COL_Quantidade = 4;

    public TableModel(){
        this.lista = new ArrayList<>();
        fireTableDataChanged();

    }

    @Override
    public int getRowCount(){
        return this.lista.size();
    }

    @Override
    public int getColumnCount(){
        return 5;
    }
    public void setLista(List<Produto> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return column != COL_ID;
    }
    public void removeLinha(int row) {
        lista.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void atualizarDados(int linhaSelecionada, String nome, String descricao, double preco, int quantidade) {
        int id = Integer.parseInt(getValueAt(linhaSelecionada, 0).toString());
        lista.set(linhaSelecionada, new Produto(id, nome, descricao, preco, quantidade));
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column){

        switch (column){
            case COL_ID:
                return "ID";
             case COL_Nome:
                return "Nome";
             case COL_Descricao:
                return "Descrição";
             case COL_Preco:
                return "Preço";
             case COL_Quantidade:
                return "Quantidade";
            default:
                break;
            
        }
        return "";
    }

    @Override
    public Object getValueAt(int row, int col){
        Produto produto = this.lista.get(row);

        switch (col) {
            case COL_ID:
                return produto.getId();
            case COL_Nome:
                return produto.getNome();
            case COL_Descricao:
                return produto.getDescricao();
            case COL_Preco:
                return produto.getPreco();
            case COL_Quantidade:
                return produto.getQuantidade();
            default:
                return "";
        }
       
    }

}