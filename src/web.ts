import { WebPlugin } from '@capacitor/core';
import { WallpaperPlugin } from './definitions';

export class WallpaperWeb extends WebPlugin implements WallpaperPlugin {
  constructor() {
    super({
      name: 'Wallpaper',
      platforms: ['web'],
    });
  }

  async echo(options: { value: string, type: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

const Wallpaper = new WallpaperWeb();

export { Wallpaper };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(Wallpaper);
