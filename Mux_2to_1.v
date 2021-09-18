module Mux_2to_1(
  input         clock,
  input         reset,
  input  [31:0] io_in_A,
  input  [31:0] io_in_B,
  input         io_select,
  output [31:0] io_out
);
  assign io_out = io_select ? io_in_A : io_in_B; // @[Main.scala 39:17]
endmodule
