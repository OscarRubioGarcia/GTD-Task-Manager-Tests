package uo.sdi.tests;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.*;

public class Sesion3Tests {

    private WebTester john;
    private WebTester mary;


	@Before
    public void prepare() {
    	john=new WebTester();
    	john.setBaseUrl("http://localhost:8280/sesion3.MVCCasero");
    	
    	mary=new WebTester();
    	mary.setBaseUrl("http://localhost:8280/sesion3.MVCCasero");
    }
	
    @Test
    public void testListarCategorias() {
    	john.beginAt("/");  // Navegar a la URL
    	john.assertLinkPresent("listarCategorias_link_id");  // Comprobar que existe el hipervínculo
    	john.clickLink("listarCategorias_link_id"); // Seguir el hipervínculo

    	john.assertTitleEquals("TaskManager - Listado de categorías");  // Comprobar título de la página

        // La base de datos contiene 7 categorías tal y como se entrega
        int i=0;
        for (i=0;i<7;i++)
        	john.assertElementPresent("item_"+i); // Comprobar elementos presentes en la página
        
        //Mas categorias si fueron añadidas
        //john.assertElementNotPresent("item_"+i);
    }
    
    @Test
    public void testNavegarListadosInbox() {
    	WebTester browser=new WebTester();
    	browser.beginAt("/");  // Navegar a la URL
    	browser.assertFormPresent("validarse_form_name");  // Comprobar formulario está presente
    	browser.setTextField("nombreUsuario", "mary"); // Rellenar primer campo de formulario
    	browser.setTextField("password", "mary123"); 
    	browser.submit(); // Enviar formulario
    	browser.assertTitleEquals("TaskManager - Página principal del usuario");  // Comprobar título de la página
    	browser.assertTextInElement("login", "mary");  // Comprobar cierto elemento contiene cierto texto
    	browser.assertTextPresent("Iniciaste sesión el"); // Comprobar cierto texto está presente
    	browser.assertTextPresent("Mostrar Inbox de Tareas");
    	browser.clickLink("listarTareasInbox");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.clickButtonWithText("Mostrar Tareas de Inbox Filtradas Tareas");
    	browser.assertTextPresent("Tarea sin categoria");
    }
    
    @Test
    public void testNavegarListadosHoy() {
    	WebTester browser=new WebTester();
    	browser.beginAt("/");  // Navegar a la URL
    	browser.assertFormPresent("validarse_form_name");  // Comprobar formulario está presente
    	browser.setTextField("nombreUsuario", "mary"); // Rellenar primer campo de formulario
    	browser.setTextField("password", "mary123"); 
    	browser.submit(); // Enviar formulario
    	browser.assertTitleEquals("TaskManager - Página principal del usuario");  // Comprobar título de la página
    	browser.assertTextInElement("login", "mary");  // Comprobar cierto elemento contiene cierto texto
    	browser.assertTextPresent("Iniciaste sesión el"); // Comprobar cierto texto está presente
    	browser.assertTextPresent("Mostrar Inbox de Tareas");
    	browser.clickLink("listarTareasInbox");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.clickLink("listarTareas");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.assertTextPresent("Task 5 for category @Home");
    }
    
    @Test
    public void testNavegarListadosSemana() {
    	WebTester browser=new WebTester();
    	browser.beginAt("/");  // Navegar a la URL
    	browser.assertFormPresent("validarse_form_name");  // Comprobar formulario está presente
    	browser.setTextField("nombreUsuario", "mary"); // Rellenar primer campo de formulario
    	browser.setTextField("password", "mary123"); 
    	browser.submit(); // Enviar formulario
    	browser.assertTitleEquals("TaskManager - Página principal del usuario");  // Comprobar título de la página
    	browser.assertTextInElement("login", "mary");  // Comprobar cierto elemento contiene cierto texto
    	browser.assertTextPresent("Iniciaste sesión el"); // Comprobar cierto texto está presente
    	browser.assertTextPresent("Mostrar Inbox de Tareas");
    	browser.clickLink("listarTareasInbox");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.clickLink("listarTareasSemana");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.assertTextPresent("Task 5 for category @Home");
    }
    
    @Test
    public void testNavegarListadosCategoria() {
    	WebTester browser=new WebTester();
    	browser.beginAt("/");  // Navegar a la URL
    	browser.assertFormPresent("validarse_form_name");  // Comprobar formulario está presente
    	browser.setTextField("nombreUsuario", "mary"); // Rellenar primer campo de formulario
    	browser.setTextField("password", "mary123"); 
    	browser.submit(); // Enviar formulario
    	browser.assertTitleEquals("TaskManager - Página principal del usuario");  // Comprobar título de la página
    	browser.assertTextInElement("login", "mary");  // Comprobar cierto elemento contiene cierto texto
    	browser.assertTextPresent("Iniciaste sesión el"); // Comprobar cierto texto está presente
    	browser.assertTextPresent("Mostrar Inbox de Tareas");
    	browser.clickLink("listarTareasInbox");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.selectOption("categoria", "@Home");
    	browser.clickButtonWithText("Buscar Tareas Por Categoria");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.assertTextPresent("Task 4 for category @Home");
    }
    
    @Test
    public void testEditarCategoria() {
    	WebTester browser=new WebTester();
    	browser.beginAt("/");  // Navegar a la URL
    	browser.assertFormPresent("validarse_form_name");  // Comprobar formulario está presente
    	browser.setTextField("nombreUsuario", "mary"); // Rellenar primer campo de formulario
    	browser.setTextField("password", "mary123"); 
    	browser.submit(); // Enviar formulario
    	browser.assertTitleEquals("TaskManager - Página principal del usuario");  // Comprobar título de la página
    	browser.assertTextInElement("login", "mary");  // Comprobar cierto elemento contiene cierto texto
    	browser.assertTextPresent("Iniciaste sesión el"); // Comprobar cierto texto está presente
    	browser.assertTextPresent("Mostrar Inbox de Tareas");
    	browser.clickLink("listarTareasInbox");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.selectOption("categoriaEdit", "New");
    	browser.setTextField("categoryName", "NuevaCategoriaVacia"); 
    	browser.clickButtonWithText("Comfirmar Cambios");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.selectOption("categoria", "NuevaCategoriaVacia");
    }
    
    @Test
    public void testEditarTask() {
    	WebTester browser=new WebTester();
    	browser.beginAt("/");  // Navegar a la URL
    	browser.assertFormPresent("validarse_form_name");  // Comprobar formulario está presente
    	browser.setTextField("nombreUsuario", "mary"); // Rellenar primer campo de formulario
    	browser.setTextField("password", "mary123"); 
    	browser.submit(); // Enviar formulario
    	browser.assertTitleEquals("TaskManager - Página principal del usuario");  // Comprobar título de la página
    	browser.assertTextInElement("login", "mary");  // Comprobar cierto elemento contiene cierto texto
    	browser.assertTextPresent("Iniciaste sesión el"); // Comprobar cierto texto está presente
    	browser.assertTextPresent("Mostrar Inbox de Tareas");
    	browser.clickLink("listarTareasInbox");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.clickLinkWithText("Editar"); 
    	browser.setTextField("newTaskName", "NuevaCategoriaVacia");  	
    	browser.selectOption("categoria", "None");
    	browser.clickButtonWithText("Terminar");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.assertTextPresent("NuevaCategoriaVacia");
    	
    	browser.clickLinkWithText("Editar"); 
    	browser.setTextField("newTaskName", "Tarea sin categoria");  	
    	browser.selectOption("categoria", "None");
    	browser.clickButtonWithText("Terminar");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.assertTextPresent("Tarea sin categoria");
    }

    @Test
    public void testIniciarSesionConExito() {
    	john.beginAt("/");  // Navegar a la URL
    	john.assertFormPresent("validarse_form_name");  // Comprobar formulario está presente
    	john.setTextField("nombreUsuario", "john"); // Rellenar primer campo de formulario
    	john.setTextField("password", "john123"); 
    	john.submit(); // Enviar formulario
    	john.assertTitleEquals("TaskManager - Página principal del usuario");  // Comprobar título de la página
    	john.assertTextInElement("login", "john");  // Comprobar cierto elemento contiene cierto texto
    	john.assertTextInElement("id", "2");  // Comprobar cierto elemento contiene cierto texto
    	john.assertTextPresent("Iniciaste sesión el"); // Comprobar cierto texto está presente
    }

    
    @Test
    public void testIniciarSesionSinExito() {
    	WebTester browser=new WebTester();
    	browser.setBaseUrl("http://localhost:8280/sesion3.MVCCasero");        
    	browser.beginAt("/");  // Navegar a la URL
    	browser.setTextField("nombreUsuario", "yoNoExisto"); // Rellenar primer campo de formulario
    	browser.setTextField("password", "yoNoExisto123"); 
    	browser.submit(); // Enviar formulario
    	browser.assertTitleEquals("TaskManager - Inicie sesión");  // Comprobar título de la página
    }
    
	@Test
    public void testNavegarListadosAñadirTareaYFinzalizarTarea() {
		WebTester browser=new WebTester();
		browser.beginAt("/");  // Navegar a la URL
		browser.assertFormPresent("validarse_form_name");  // Comprobar formulario está presente
		browser.setTextField("nombreUsuario", "mary"); // Rellenar primer campo de formulario
		browser.setTextField("password", "mary123"); 
		browser.submit(); // Enviar formulario
		browser.assertTitleEquals("TaskManager - Página principal del usuario");  // Comprobar título de la página
		browser.assertTextInElement("login", "mary");  // Comprobar cierto elemento contiene cierto texto
		browser.assertTextPresent("Iniciaste sesión el"); // Comprobar cierto texto está presente
    	browser.assertTextPresent("Mostrar Inbox de Tareas");
    	browser.clickLink("listarTareasInbox");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.setTextField("taskName", "Tarea no Finalizada"); 
    	browser.selectOption("categoria", "None");
    	browser.clickButtonWithText("Añadir Tarea");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.clickButtonWithText("Mostrar Tareas de Inbox Filtradas Tareas");
    	browser.assertTextPresent("Tarea no Finalizada");
    	
    	browser.beginAt("/");  // Navegar a la URL
    	browser.submit(); // Enviar formulario
    	
    	browser.assertFormPresent("validarse_form_name");  // Comprobar formulario está presente
    	browser.setTextField("nombreUsuario", "mary"); // Rellenar primer campo de formulario
    	browser.setTextField("password", "mary123"); 
    	browser.submit(); // Enviar formulario
    	browser.assertTitleEquals("TaskManager - Página principal del usuario");  // Comprobar título de la página
    	browser.assertTextInElement("login", "mary");  // Comprobar cierto elemento contiene cierto texto
    	browser.assertTextPresent("Iniciaste sesión el"); // Comprobar cierto texto está presente
    	browser.assertTextPresent("Mostrar Inbox de Tareas");
    	browser.clickLink("listarTareasInbox");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.clickButtonWithText("Mostrar Tareas de Inbox Filtradas Tareas");
    	browser.assertTextPresent("Tarea sin categoria");
    	browser.clickLinkWithText("Finalizar");
    	browser.assertTextPresent("Listados de Tareas");
    	browser.clickButtonWithText("Mostrar Tareas de Inbox Filtradas Tareas");
    	browser.assertTextNotPresent("Tarea sin categoria");
    }

}