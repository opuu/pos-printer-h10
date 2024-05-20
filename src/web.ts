import { WebPlugin } from '@capacitor/core';

import type { POSH10Plugin } from './definitions';

export class POSH10Web extends WebPlugin implements POSH10Plugin {
  async getServiceVersion(): Promise<{ version: string }> {
    return Promise.reject('Web implementation not available');
  }

  async printText(): Promise<void> {
    return Promise.reject('Web implementation not available');
  }

  async printImage(): Promise<void> {
    return Promise.reject('Web implementation not available');
  }
}
