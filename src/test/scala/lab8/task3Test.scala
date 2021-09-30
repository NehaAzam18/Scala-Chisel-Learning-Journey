package lab8
import chisel3._ 
import org.scalatest._
import chiseltest._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task3Test extends FreeSpec with ChiselScalatestTester{
  "Instruction test" in {
    test(new task3){ c =>
    c.io.addr.poke(3.U)
    c.io.inst.poke(16.U)
    c.io.wr_en.poke(1.B)
    c.clock.step(20)
    }
  }
}
        