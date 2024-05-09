export interface POSH10Plugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
