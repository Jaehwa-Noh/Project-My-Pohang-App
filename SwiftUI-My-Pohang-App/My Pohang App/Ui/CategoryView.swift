//
//  CategoryView.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import SwiftUI

struct CategoryView: View {
    var body: some View {
        Form {
            Section {
                ForEach(CategoryAndRecommendRepository().categories) {
                    category in
                    NavigationLink {
                        
                    } label: {
                        HStack {
                            Image(systemName: category.iconName)
                            Text("\(category.categoryName)")
                        }
                    }
                }
            }
        }
    }
}

#Preview {
    CategoryView()
}
