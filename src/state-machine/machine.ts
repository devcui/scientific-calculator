export type State = string;
export type Event = string;

export interface Context {
  [key: string]: any;
}

export interface Transition {
  from: State;
  to: State;
  event: Event;
  condition?: (context: Context) => boolean;
  action?: (context: Context) => void;
}

export class Machine {
  private state: State | null = null;
  private context: Context = {};
  private transitions: Map<string, Transition> = new Map();

  public setInitalState(state: State): void {
    this.state = state;
  }

  public setContext(context: Context): void {
    this.context = { ...this.context, ...context };
  }

  public addTransition(
    from: State,
    to: State,
    event: Event,
    condition?: (ctx: Context) => boolean,
    action?: (ctx: Context) => void
  ): void {
    const key = `${from}-${event}`;
    this.transitions.set(key, { from, to, event, condition, action });
  }

  public removeTransition(from: State, event: Event): void {
    const key = `${from}-${event}`;
    this.transitions.delete(key);
  }

  public send(event: Event): void {
    if (!this.state) {
      console.error("Initial state not set");
      return;
    }
    const key = `${this.state}-${event}`;
    const transition = this.transitions.get(key);
    if (
      transition &&
      (!transition.condition || transition.condition(this.context))
    ) {
      this.state = transition.to;
      if (transition.action) transition.action(this.context);
    } else {
      console.error(`No valid transition for ${key}`);
    }
  }

  public getState(): State | null {
    return this.state;
  }

  public getContext(): Context {
    return { ...this.context };
  }
}
