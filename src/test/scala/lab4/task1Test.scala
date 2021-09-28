package lab4
import chisel3 . _
import chisel3 . util
import org . scalatest . _
import chiseltest . _
import chiseltest . experimental . TestOptionBuilder . _
import chiseltest . internal . VerilatorBackendAnnotation
import scala . util . Random
class task1Test extends FreeSpec with ChiselScalatestTester {
"BranchControl Test" in {
test(new task1()) { c =>

for ( i <- 0 until 100) {
val src_a = Random . nextLong () & 0xFFFFFFFFL
println("*****src_a******",src_a)
val src_b = Random . nextLong () & 0xFFFFFFFFL
println("*****src_b******",src_b)
val fnct = Random . nextInt (5)
println("*****funct******",fnct)

val result = fnct match {
  case(0) => if(src_a == src_b) 1 else 0
  case(1) => if(src_a != src_b) 1 else 0
  case(2) => 0
  case(3) => 0
  case(5) => if(src_a >= src_b) 1 else 0
  case(4) => if(src_a <= src_b) 1 else 0
  case(6) => if(src_a <= src_b) 1 else 0
  case(7) => if(src_a >= src_b) 1 else 0
  case _ => 0
}
println("*****result******",result)
c . io . arg_x . poke ( src_a . U )
c.io.arg_y.poke ( src_b . U )
c.io.branch.poke(1.B)
c.io.fnct3.poke(fnct.U)
c.clock.step (1)
c.io.br_taken.expect(result.B)
}
c . clock . step (2)
}
}
}
