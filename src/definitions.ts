export interface POSH10Plugin {
  getServiceVersion(options: {}): Promise<{ version: string }>;
  printText(options: { text: string }): Promise<void>;
  printImage(options: { base64: string }): Promise<void>;
}
