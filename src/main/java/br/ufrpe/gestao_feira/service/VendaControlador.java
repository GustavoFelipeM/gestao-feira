package br.ufrpe.gestao_feira.service;

import br.ufrpe.gestao_feira.classesbasicas.*;
import br.ufrpe.gestao_feira.exceptions.ProdutoInvalidoException;
import br.ufrpe.gestao_feira.exceptions.ProdutoNaoAssociadoException;
import br.ufrpe.gestao_feira.repositorio.interfaces.IEdicaoFeiraRepositorio;
import br.ufrpe.gestao_feira.repositorio.interfaces.IItemVendaRepositorio;
import br.ufrpe.gestao_feira.repositorio.interfaces.IVendaRepositorio;

import java.util.List;

public class VendaControlador
{
    private final IVendaRepositorio vendaRepositorioControlador;
    private final IItemVendaRepositorio itemVendaRepositorioControlador;

    public VendaControlador (IVendaRepositorio vendaRepositorio, IItemVendaRepositorio itemVendaRepositorio)
    {
        this.vendaRepositorioControlador = vendaRepositorio;
        this.itemVendaRepositorioControlador = itemVendaRepositorio;
    }

    public void registrarVenda(Produtor produtor, EdicaoFeira edicaoFeira, List<ItemVenda> itensVenda, String observacao) throws Exception
    {
        if (produtor == null || edicaoFeira == null || itensVenda == null || itensVenda.isEmpty())
        {
            throw new IllegalArgumentException("Dados da venda incompletos");
        }

        boolean participou = false;
        int banca = -1;
        for (Participacao p : edicaoFeira.getParticipacoes())
        {
            if (p != null && p.getProdutor().equals(produtor))
            {
                participou = true;
                banca = p.getBanca();
                break;
            }
        }
        if (!participou)
        {
            throw new IllegalStateException("Produtor não participou da edição especificada");
        }
        for (ItemVenda itemVenda : itensVenda)
        {
            Produto produto = itemVenda.getProduto();
            if(!produto.getProdutorAssociado().equals(produtor))
            {
                throw new ProdutoNaoAssociadoException(produto, produtor);
            }
        }
        Venda venda = new Venda(produtor, edicaoFeira, observacao);

        venda.setBanca(banca);
        for (ItemVenda itemVenda : itensVenda)
        {
            venda.adicionarItemVenda(itemVenda);
        }
        vendaRepositorioControlador.add(venda);
    }

    public double calcularTotalVendidoPorBanca(EdicaoFeira edicaoFeira, int numeroBanca)
    {
        double totalVendido = 0;
        List<Venda> vendas = vendaRepositorioControlador.buscarVendasPorEdicao(edicaoFeira);
        {
            for (Venda venda : vendas)
            {
                if (venda.getBanca() == numeroBanca)
                {
                    totalVendido += venda.calcularVendaTotal();
                }
            }
            return  totalVendido;
        }
    }

}
