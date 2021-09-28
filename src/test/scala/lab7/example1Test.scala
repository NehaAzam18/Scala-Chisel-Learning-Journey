package lab7
import chisel3._ 
import org.scalatest._
import chiseltest._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class example1Test extends FreeSpec with ChiselScalatestTester{
  "DetectSequence test" in {
    test(new example1){ c =>
    c.io.in.poke(1.B)
    c.clock.step(20)
    }
  }
}