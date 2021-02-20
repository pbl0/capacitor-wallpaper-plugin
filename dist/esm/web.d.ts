import { WebPlugin } from '@capacitor/core';
import { WallpaperPlugin } from './definitions';
export declare class WallpaperWeb extends WebPlugin implements WallpaperPlugin {
    constructor();
    echo(options: {
        value: string;
        type: string;
    }): Promise<{
        value: string;
    }>;
}
declare const Wallpaper: WallpaperWeb;
export { Wallpaper };
