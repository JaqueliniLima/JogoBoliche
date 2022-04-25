package boliche;

public class PontuacaoSpare implements Pontuacao, DisplayAnimacao {

	@Override
	public void apresentarResultado() {
		System.out.println("SPARE!");
		this.display();
	}
	
	@Override
	public void display() {
		System.out.println( "                       @@@@@ @@@@@@ @@@@@@  @@@@@  @@@@@@                       \r\n" + 
							"                       @     @    @ @    @  @   @  @                            \r\n" + 
							"                       @@@@@ @@@@@@ @@@@@@  @@@@   @@@@                         \r\n" + 
							"                           @ @      @    @  @  @   @                            \r\n" + 
							"                       @@@@@ @      @    @  @   @  @@@@@@                       \r\n" +
							"                                                                                \r\n" + 
							"                                                                                \r\n" + 
							"                                                 @@@@@                          \r\n" + 
							"                       @@@@&      @@@   @@     @@     @@                        \r\n" + 
							"                     @@     @@    @      @@   @@       @@                       \r\n" + 
							"                     @      @@    @@     @@    @@     @@                        \r\n" + 
							"                      @@    @@     @@ &@@@@    (@@@@@@@(                        \r\n" + 
							"                       @@@@@ @@    @@    @@    @@     @@                        \r\n" + 
							"                       *@ @@@@@@@  @@@@@   @  @@       @@                       \r\n" + 
							"                       %@        @@@@@@@@@@@@@@         @@                      \r\n" + 
							"                       @@       .@@@@@@@@@@@@@           @                      \r\n" + 
							"                       @@      @@@@  @@@   @@@           @@                     \r\n" + 
							"                        @    *@@@@@  @@@@@@@@(           (@                     \r\n" + 
							"                        @@   @@@@@@@@@@   @@@(           #@                     \r\n" + 
							"                         @@  @@@@@@@@@@@@@@@@@           @@                     \r\n" + 
							"                          @@  @@@@@@@@@@@@@@@@           @@                     \r\n" + 
							"                           @@  &@@@@@@@@@@@@@@           @                      \r\n" + 
							"                                  @@@@@@@@@@@@@@@@@@@@@@@@                      ");	
	}
	
}
