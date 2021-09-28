package lab5
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task2Test extends FreeSpec with ChiselScalatestTester{
  "MUX test" in {
    test(new task2(2.S)){ c =>
        c.io.in1.poke(2.S)
        c.io.in2.poke(1.S)
        c.io.sel.poke(1.B)
        c.io.out.expect(2.S)
        c.clock.step(1)
    }
  }
}