package atividade6.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ClienteTest.class, EstoqueTest.class, GerenciadorClienteTest.class , ItemPedidoTest.class, PedidoTest.class, ProdutoTest.class})
public class AllTests {

}
