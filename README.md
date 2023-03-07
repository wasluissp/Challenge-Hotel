
# Aplicação Desktop Java - Sistema de Reservas de Hotel

Este programa integra funções gráficas com lógica para a execução de um sistema de reservas de hotel aplicando padrões de controle para maximizar o uso do projeto.

### 🖥️ Tecnologías Utilizadas:

Java

Eclipse

Biblioteca JCalendar

MySql

Plugin WindowBuilder

mariadb-java-client-3.1.1.jar

***

### ⚠️ Importante! ⚠️

Compativel com Java versão 8 ou superior.

#### Requer a importação das seguinte bibliotecas externas:

![Librerías externas](src/imagens/bibliotecasExternas.png)

#### Requer a importação da biblioteca externa do mariadb. (mariadb-java-client-3.1.1.jar).

#### Requer a criação previa de um banco de dados com duas tabelas, as quais devem ser configuradas no arquivo ConnectionFactory.java:

![Base de Dados](src/imagens/bdTabelas.png)

#### 🎨 A interface contém dois métodos importantes:

setResizable(false): determina o tamanho da janela,  através do parâmetro false, a janela não maximiza.

setLocationRelativeTo(null): determina localização da janela e, por meio do parâmetro null, a mantém centralizada na tela.

***

### A janela com a qual o aplicativo deve ser iniciado é o Menu Principal (MenuPrincipal.java):

![Menu Principal](src/imagens/MenuPrincipal.png)

***

A partir do qual você pode continuar graficamente para o Login:

![Login](src/imagens/Inicio.png)

#### Os dados definidos para poder validar a entrada são:
Usuario= alura

Senha= alura

***

Uma vez introduzidos os dados de acesso, a aplicação permitirá optar por criar uma reserva ou efetuar uma pesquisa de reserva existente ou registo de hóspede.

![Opções](src/imagens/opções.png)

#### Registro de Reserva

![Criar reserva](src/imagens/CriarReserva.png) 

***

![Registrar Hospede](src/imagens/registrarHospede.png)

***

![Dados salvos](src/imagens/dadosSalvos.png)

***

Se você escolheu a opção Pesquisar, pode optar por editar ou excluir o registro selecionado ou realizar uma pesquisa específica por número de identificação..

![Editar ou eliminar Registro](src/imagens/editarOueliminar.png)

***

![Alterar, Janela de Confirmação](src/imagens/ConfirmaEdição.png)

***

![Sistema pede confirmação exclusão](src/imagens/confirmar.png)

***

![Buscas por número de Id](src/imagens/buscaPorId.png)

***

Por fim, você pode voltar ou fechar o aplicativo com os ícones disponíveis na parte superior de cada janela.

![Ícones de voltar e fechar](src/imagens/icones.png)

