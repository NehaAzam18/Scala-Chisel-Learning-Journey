;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Mux_2to_1 : 
  module Mux_2to_1 : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in_A : UInt<32>, flip in_B : UInt<32>, flip select : UInt<1>, out : UInt}
    
    node _io_out_T = mux(io.select, io.in_A, io.in_B) @[Main.scala 39:17]
    io.out <= _io_out_T @[Main.scala 39:10]
    
