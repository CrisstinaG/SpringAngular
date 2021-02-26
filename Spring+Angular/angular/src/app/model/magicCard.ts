export class magicCard {
    name: string;
    rarity:string;
    types:string;
    url:string;    
  
      constructor(json: any) {
          this.name = json.name;
          this.rarity = json.rarity;
          this.types =json.types
          this.url = json.imagUrl;
      }
  }