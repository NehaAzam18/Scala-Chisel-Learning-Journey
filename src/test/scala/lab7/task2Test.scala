package lab7
import chisel3._ 
import org.scalatest._
import chiseltest._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task2Test extends FreeSpec with ChiselScalatestTester{
  "FSM test" in {
    test(new task2){ c =>
    c.io.f1.poke(0.B)
    c.io.f2.poke(1.B)
    c.io.r1.poke(0.B)
    c.io.r2.poke(0.B)
    c.clock.step(20)
    }
  }
}