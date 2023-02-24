enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
       	inscritos.add(usuario)
    }
    
    fun matricular(usuarios: List<Usuario>) {
       	for(usuario in usuarios){
	        inscritos.add(usuario)
        }
    }
    
    fun cargaHorariaTotal(): Int{
    	var horas: Int = 0
        for(conteudo in conteudos){
			horas += conteudo.duracao
		}
        return horas
    }
    
    fun conteudos() {
    	for(conteudo in conteudos){
        	println("${conteudo.nome} - ${conteudo.duracao}h")
        }
    }
    
    fun mostrarInscritos(){
    	for(inscrito in inscritos){
        	println("${inscrito.nome}")
        }
	}
}

fun main() {
    cenario1()
}

fun cenario1(){
	val almeida = Usuario("Almeida")
    val anderson = Usuario("Anderson")
    
    val listaConteudosKotlin: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Introdução ao Desenvolvimento Moderno de Software",5),
        ConteudoEducacional("Funcoes em Kotlin",2),
        ConteudoEducacional("Orientação a Objetos - POO",6),
    	ConteudoEducacional("Arquiteturas e Organizações Computacionais",10))

    val kotlinExperience = Formacao("Kotlin Experience", listaConteudosKotlin, Nivel.BASICO)

    kotlinExperience?.let{
        kotlinExperience.matricular(listOf(almeida, anderson))
    }

    println("Formação: ${kotlinExperience.nome} - ${kotlinExperience.cargaHorariaTotal()} horas de estudo")
    
    println("\nConteúdos:")
    kotlinExperience.conteudos()
    
    println("\nInscritos:")
    kotlinExperience.mostrarInscritos()

}
