package lab5
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task4Test extends FreeSpec with ChiselScalatestTester{
  "Adder test" in {
    test(new task4(18 , 30 , 32)){ c =>
        c.io.in.poke(2.U)
        c.io.out.expect(4.U)
        c.clock.step(1)
    }
  }
}