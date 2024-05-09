import { WebPlugin } from '@capacitor/core';

import type { POSH10Plugin } from './definitions';

export class POSH10Web extends WebPlugin implements POSH10Plugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
