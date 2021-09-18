;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Mux_Tree : 
  module Mux_Tree : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : UInt<4>, flip s1 : UInt<1>, flip s2 : UInt<1>, flip s3 : UInt<1>, out : UInt<1>}
    
    node _io_out_T = bits(io.in, 3, 3) @[Main.scala 71:37]
    node _io_out_T_1 = bits(io.in, 2, 2) @[Main.scala 71:67]
    node _io_out_T_2 = bits(io.in, 1, 1) @[Main.scala 72:25]
    node _io_out_T_3 = bits(io.in, 0, 0) @[Main.scala 72:39]
    node _io_out_T_4 = mux(io.s1, _io_out_T_2, _io_out_T_3) @[Main.scala 72:5]
    node _io_out_T_5 = mux(io.s2, _io_out_T_1, _io_out_T_4) @[Main.scala 71:47]
    node _io_out_T_6 = mux(io.s3, _io_out_T, _io_out_T_5) @[Main.scala 71:17]
    io.out <= _io_out_T_6 @[Main.scala 71:10]
    
