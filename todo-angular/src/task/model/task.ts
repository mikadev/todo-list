export class Task {
  id: number;
  description: string;
  done: boolean;


  constructor(description: string) {
    this.description = description;
  }
}
