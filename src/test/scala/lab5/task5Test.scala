package lab5
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task5Test extends FreeSpec with ChiselScalatestTester{
  "Adder test" in {
    test(new task5(2)){ c =>
        c.io.in1.poke(2.U)
        c.io.in2.poke(1.U)
        c.io.out.expect(3.U)
        c.clock.step(1)
    }
  }
}