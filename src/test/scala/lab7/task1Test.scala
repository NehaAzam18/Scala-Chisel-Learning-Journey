package lab7
import chisel3._ 
import org.scalatest._
import chiseltest._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task1Test extends FreeSpec with ChiselScalatestTester{
  "Arbiter test" in {
    test(new task1){ c =>
    c.io.in(0).bits.poke(11.U)
    c.io.in(1).bits.poke(10.U)
    c.io.in(0).valid.poke(1.B)
    c.io.in(1).valid.poke(1.B)
    c.io.out.ready.poke(1.B)
    c.clock.step(20)
    }
  }
}