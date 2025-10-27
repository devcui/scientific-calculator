import { Machine } from "./machine";

export function main() {
  const stateMachine = new Machine();

  stateMachine.setContext({
    light: "off",
  });

  stateMachine.addTransition(
    "OFF",
    "ON",
    "TURN_ON",
    (ctx) => {
      return ctx.light === "off";
    },
    (ctx) => {
      ctx.light = "on";
      console.log("The light is turned on");
    }
  );

  stateMachine.addTransition(
    "ON",
    "OFF",
    "TURN_OFF",
    (ctx) => {
      return ctx.light === "on";
    },
    (ctx) => {
      ctx.light = "off";
      console.log("The light is turned off");
    }
  );

  stateMachine.setInitalState("OFF");
  console.log("Initial light state:", stateMachine.getState());
  stateMachine.send("TURN_ON");
  console.log("Current light state:", stateMachine.getState());
  stateMachine.send("TURN_OFF");
  console.log("Final light state:", stateMachine.getState());
}

main();