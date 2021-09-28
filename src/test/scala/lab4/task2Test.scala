package lab4
import chisel3 . _
import chisel3 . util
import org . scalatest . _
import chiseltest . _
import chiseltest . experimental . TestOptionBuilder . _
import chiseltest . internal . VerilatorBackendAnnotation
import scala . util . Random
class task2Test extends FreeSpec with ChiselScalatestTester {
"ImmediateGen Test" in {
test(new task2()) { c =>
val imm_arr = Array("h00800513","h00B02623","h00058863","h000065B7") //,"h00B02623","h014000EF","h00058863","h000041B7")
for ( i <- 0 until 100) {
//val src_a = Random . nextLong () & 0xFFFFFFFFL
// val src_b = Random . nextLong () & 0xFFFFFFFFL
val in = Random . nextInt (3)
//println("******in*****",in)
val inst = imm_arr(in)
val result = inst match {
  case("h00800513") => 8  //Itype
 case("h00B02623") => 12 //Stype
 //case("h014000EF") => 20 //J Type
   case("h00058863") => 16 //B Type
   case("h000065B7") => 6 //U Type
  case _ => 0
}
println("********result******", result)
c . io . instr . poke ( inst . U )
c.clock.step (1)
c.io.immd_sel.expect(result.U)
}
c . clock . step (2)
}
}
}
