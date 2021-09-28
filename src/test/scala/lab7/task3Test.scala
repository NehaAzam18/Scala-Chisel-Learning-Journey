package lab7
import chisel3._ 
import org.scalatest._
import chiseltest._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task3Test extends FreeSpec with ChiselScalatestTester{
  "Manchester_Encoding test" in {
    test(new task3){ c =>
    c.io.start.poke(1.B)
    
    c.io.in.poke(0.U)
    c.clock.step(1)
    c.io.in.poke(1.U)
    c.clock.step(1)
    c.io.in.poke(0.U)
    c.clock.step(1)
    c.io.in.poke(0.U)
    c.clock.step(1)
    c.io.in.poke(1.U)
    c.clock.step(1)
    
    //c.clock.step(20)
    }
  }
}